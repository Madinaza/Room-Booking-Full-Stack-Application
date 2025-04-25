import React, { useState, useEffect } from 'react';
import Login from './components/Login';
import RoomList from './components/RoomList';
import BookingForm from './components/BookingForm';
import BookingList from './components/BookingList';
import { createWs } from './ws';
import { Booking } from './models';

function App() {
  const [live, setLive] = useState<Booking[]>([]);
  useEffect(() => {
    const ws = createWs((b: Booking) => setLive(prev => [...prev, b]));
    return () => ws.deactivate();
  }, []);
  return (
    <div style={{ padding: 24 }}>
      <h1>Room Booking</h1>
      <Login/>
      <RoomList/>
      <BookingForm onNew={b => setLive(prev => [...prev, b])}/>
      <BookingList liveUpdates={live}/>
    </div>
  );
}

export default App;
