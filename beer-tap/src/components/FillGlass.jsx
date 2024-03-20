import React from 'react'
import { useSelector } from 'react-redux';
import useFillGlass from '../hooks/fillGlassHook';

export default function FillGlass() {
    const tapSlice = useSelector(state => state.tap);
    const { id } = tapSlice;
    const fillGlass = useFillGlass();

    return (
        <button className='cursor-pointer focus:outline-none text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-900' onClick={() => fillGlass(id)}>Fill my glass!</button>
    );
}
