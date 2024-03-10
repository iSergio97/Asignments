import React from 'react';
import { useSelector } from 'react-redux';

export default function Header() {
  const tap = useSelector(state => state.tap);
  return (
    <div>
      <header>
        <h1>React redux</h1>
        <h3> Tap ID: {tap.tapId}</h3>
        <h3> Tap Status: {tap.status}</h3>
      </header>
    </div>
  )
}
