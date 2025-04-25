import React, { useEffect, useState } from 'react';
import api from '../api';
import { Booking } from '../models';

interface Props { liveUpdates:Booking[]; }

export default function BookingList({liveUpdates}:Props){
  const [initial,setInit]=useState<Booking[]>([]);
  useEffect(()=>{ api.get<Booking[]>('/bookings').then(r=>setInit(r.data)); },[]);
  const all=[...initial,...liveUpdates];
  return (
    <div>
      <h2>Bookings</h2>
      <ul>
        {all.map(b=>
          <li key={b.id}>
            Room {b.roomId} by User {b.userId}: {b.startTime} → {b.endTime}
          </li>
        )}
      </ul>
    </div>
  );
}
