import React, { useState, useEffect } from 'react';
import api from '../api';
import { Room, Booking } from '../models';

interface Props { onNew(b:Booking):void; }

export default function BookingForm({onNew}:Props){
  const [rooms,setRooms]=useState<Room[]>([]),
        [roomId,setRoomId]=useState<number|''>(''),
        [start,setStart]=useState(''),[end,setEnd]=useState('');
  useEffect(()=>{ api.get<Room[]>('/rooms').then(r=>setRooms(r.data)); },[]);
  const submit=async()=>{
    if(!roomId||!start||!end)return alert('All fields');
    const res=await api.post<Booking>('/bookings',{roomId,startTime:start,endTime:end});
    onNew(res.data);
  };
  return (
    <div>
      <h2>New Booking</h2>
      <select onChange={e=>setRoomId(+e.target.value)}>
        <option value="">Select…</option>
        {rooms.map(r=><option key={r.id} value={r.id}>{r.name}</option>)}
      </select>
      <input type="datetime-local" onChange={e=>setStart(e.target.value)}/>
      <input type="datetime-local" onChange={e=>setEnd(e.target.value)}/>
      <button onClick={submit}>Book</button>
    </div>
  );
}
