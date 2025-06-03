import React, { useState } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const LoginForm = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)
  const [success, setSuccess] = useState(false)
  const navigate = useNavigate()

  const handleSubmit = async (e) => {
    e.preventDefault()
    setLoading(true)
    setError('')
    setSuccess(false)
    try {
      console.log('Attempting to connect to API...')
      const response = await axios.post('http://localhost:8080/api/auth/login', {
        email: email,
        password: password,
      })
      console.log('API Response:', response.data)
      
      // Lưu thông tin đăng nhập vào localStorage
      localStorage.setItem('isLoggedIn', 'true')
      localStorage.setItem('userEmail', email)
      
      setSuccess(true)
      setError('')
      
      // Chuyển hướng sau khi đăng nhập thành công
      setTimeout(() => {
        navigate('/success')
      }, 1000) // Delay 1 giây để người dùng thấy thông báo thành công
    } catch (err) {
      console.error('API Error:', err)
      if (err.code === 'ERR_NETWORK') {
        setError('Không thể kết nối tới server. Vui lòng kiểm tra lại server đã chạy chưa!')
      } else if (err.response) {
        setError(
          err.response.status === 401
            ? 'Email hoặc mật khẩu không đúng!'
            : `Lỗi server: ${err.response.status} - ${err.response.data?.message || 'Unknown error'}`
        )
      } else if (err.request) {
        setError('Không nhận được phản hồi từ server!')
      } else {
        setError('Có lỗi xảy ra: ' + err.message)
      }
      setSuccess(false)
    }
    setLoading(false)
  }

  return (
    <div className="flex items-center justify-center min-h-screen bg-gradient-to-br from-gray-50 to-teal-50">
      <form
        onSubmit={handleSubmit}
        className="bg-white p-8 rounded-xl shadow-xl w-full max-w-sm transform transition-all duration-300 hover:shadow-2xl"
      >
        <h2 className="text-2xl font-bold mb-6 text-center text-teal-600">Đăng nhập</h2>

        <div className="mb-4">
          <label className="block mb-1 font-semibold text-gray-700">Email</label>
          <input
            type="email"
            className="w-full border border-gray-300 rounded-lg px-4 py-2 focus:outline-none focus:border-teal-500 transition-colors"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div className="mb-6">
          <label className="block mb-1 font-semibold text-gray-700">Mật khẩu</label>
          <input
            type="password"
            className="w-full border border-gray-300 rounded-lg px-4 py-2 focus:outline-none focus:border-teal-500 transition-colors"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        {error && (
          <div className="text-red-500 text-sm mb-4 p-2 bg-red-50 rounded-lg border border-red-200">
            {error}
          </div>
        )}
        {success && (
          <div className="text-green-600 text-sm mb-4 p-2 bg-green-50 rounded-lg border border-green-200">
            Đăng nhập thành công! Đang chuyển hướng...
          </div>
        )}
        <button
          type="submit"
          className="w-full bg-teal-500 hover:bg-teal-600 text-white font-semibold py-3 rounded-lg transition-colors duration-300 disabled:opacity-50 disabled:cursor-not-allowed"
          disabled={loading}
        >
          {loading ? (
            <span className="flex items-center justify-center">
              <svg className="animate-spin -ml-1 mr-3 h-5 w-5 text-white" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
                <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4"></circle>
                <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
              </svg>
              Đang xử lý...
            </span>
          ) : (
            'Đăng nhập'
          )}
        </button>
      </form>
    </div>
  )
}

export default LoginForm
