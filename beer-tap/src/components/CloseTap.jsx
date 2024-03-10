import React from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { closeTap } from '../redux/tapSlice';

export default function CloseTap() {
    const REACT_APP_API_PATH = process.env.REACT_APP_API_PATH;
    const dispatch = useDispatch();
    const tapSlice = useSelector(state => state.tap);
    const { id } = tapSlice;

    const confirmCloseTap = () => {
        if (window.confirm('Are you sure you want to close the tap?')) {
            closeTapHandle();
        }
    }

    const closeTapHandle = () => {
        fetch(REACT_APP_API_PATH + '/dispenser/' + id + '/spending', {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Prefer': 'code=200, example=default'
            }
        })
            .then(response => response.json())
            .then(data => {
                dispatch(closeTap(data));
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }

    return (
        <button className='cursor-pointer focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900' onClick={confirmCloseTap}>Close tap</button>
    )
}
