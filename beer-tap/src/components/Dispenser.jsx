import React from 'react';
import { useSelector } from 'react-redux';
import NewDispenser from './NewDispenser';
import Tap from './Tap';

export function Dispenser() {
    const tapSlice = useSelector(state => state.tap);
    const { id } = tapSlice;

    return (
        <div className='flex items-center justify-center flex-col p-8 m-0'>
            <h1 className='text-4xl font-extrabold pb-6'>
                Welcome to <span className='italic text-wrap'> Beer Tap </span>!
            </h1>
            <h4 className='text-lg pb-4'>Experience instant beer ordering with our app! Skip waiting for the bartender—select, request, and enjoy your beer faster than ever. Perfect for hassle-free, quick service that keeps your focus on enjoyment, not the wait.</h4>
            {id ? <Tap /> : <NewDispenser />}
        </div>
    );
}