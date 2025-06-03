import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom'

const SuccessPage = () => {
  const navigate = useNavigate()

  const handleLogout = () => {
    // Xóa thông tin đăng nhập nếu cần
    navigate('/')
  }

  return (
    <div className="flex items-center justify-center min-h-screen bg-gradient-to-br from-green-50 to-teal-50">
      <div className="bg-white shadow-2xl rounded-2xl p-12 text-center max-w-md w-full mx-4 transform transition-all duration-500 hover:scale-105">
        <div className="mb-8">
          <div className="w-20 h-20 bg-green-100 rounded-full flex items-center justify-center mx-auto mb-6">
            <svg className="w-10 h-10 text-green-500" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5 13l4 4L19 7" />
            </svg>
          </div>
          <h1 className="text-3xl font-bold text-green-600 mb-4">Đăng nhập thành công!</h1>
          <p className="text-lg text-gray-600 mb-6">Chào mừng bạn đã đăng nhập thành công vào hệ thống 🎉</p>
        </div>

        <div className="space-y-4">
          <button
            onClick={handleLogout}
            className="w-full bg-red-500 hover:bg-red-600 text-white font-semibold py-3 px-6 rounded-lg transition-colors duration-300"
          >
            Đăng xuất
          </button>
        </div>
      </div>
    </div>
  )
}

export default SuccessPage
