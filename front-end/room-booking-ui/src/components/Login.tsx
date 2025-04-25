import React, { useState } from 'react';
import api from '../api';
import { AuthResponse } from '../models';

export default function Login() {
  const [u,setU]=useState('user1'),[p,setP]=useState('password');
  const login=async()=>{
    const res=await api.post<AuthResponse>('/auth/login',{username:u,password:p});
    localStorage.setItem('token',res.data.token);
    window.location.reload();
  };
  return (
    <div style={{marginBottom:16}}>
      <input value={u} onChange={e=>setU(e.target.value)} placeholder="Username"/>
      <input type="password" value={p} onChange={e=>setP(e.target.value)} placeholder="Password"/>
      <button onClick={login}>Log In</button>
    </div>
  );
}
