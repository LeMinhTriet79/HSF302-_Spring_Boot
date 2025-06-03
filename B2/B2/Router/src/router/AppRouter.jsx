// src/router/AppRouter.js
import React from 'react'
import { Routes, Route } from 'react-router-dom'
import LoginForm from '../Page/Contact'
import SuccessPage from '../Page/Succes'

const AppRouter = () => (
  <Routes>
    <Route path="/" element={<LoginForm />} />
    <Route path="/success" element={<SuccessPage />} />
  </Routes>
)

export default AppRouter
