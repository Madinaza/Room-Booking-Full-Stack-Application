import React, { useEffect, useState } from 'react';
import api from '../api';
import { Room } from '../models';

export default function RoomList(){
  const [rooms,setRooms]=useState<Room[]>([]);
  useEffect(()=>{ api.get<Room[]>('/rooms').then(r=>setRooms(r.data)); },[]);
  return (
    <div>
      <h2>Rooms</h2>
      <ul>{rooms.map(r=><li key={r.id}>{r.name} ({r.capacity}) @ {r.location}</li>)}</ul>
    </div>
  );
}
