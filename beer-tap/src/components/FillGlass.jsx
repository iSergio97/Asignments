import React from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { closeTap } from '../redux/tapSlice';

export default function FillGlass() {
    const REACT_APP_API_PATH = process.env.REACT_APP_API_PATH;
    const dispatch = useDispatch();
    const tapSlice = useSelector(state => state.tap);
    const { id } = tapSlice;

    const fillGlass = () => {

        const body = {
            "status": "open",
            "updated_at": "2022-01-01T02:00:00Z"
        }

        let url = `https://stoplight.io/mocks/rviewer/beer-tap-dispenser/90004725/dispenser/${id}/status`;

        const options = {
            method: 'PUT',
            headers: { 'Prefer': '', 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        };

        fetch(url, options)
            .then(response => response)
            .catch(error => {
                console.error('Error:', error);
            });
    }

    return (
        <button className='cursor-pointer focus:outline-none text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-900' onClick={fillGlass}>Fill my glass!</button>
    )
}
