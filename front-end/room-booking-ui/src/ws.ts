import { Client } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { Booking } from './models';

export function createWs(onMsg: (b: Booking) => void) {
  const client = new Client({
    webSocketFactory: () => new SockJS('/ws-bookings'),
    onConnect: () => client.subscribe('/topic/bookings', msg => onMsg(JSON.parse(msg.body))),
  });
  client.activate();
  return client;
}
