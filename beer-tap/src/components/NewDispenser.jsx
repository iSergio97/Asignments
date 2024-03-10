import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { newDispenser } from '../redux/tapSlice';

export default function NewDispenser() {
    const REACT_APP_API_PATH = process.env.REACT_APP_API_PATH;
    const dispatch = useDispatch();

    const tap = useSelector(state => state.tap);

    const createDispenser = () => {

        const body = {
            "flow_volume": 0.0653
        };

        fetch(REACT_APP_API_PATH + '/dispenser', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Prefer': 'code=200, example=default'
            },
            body: JSON.stringify(body)
        })
            .then(response => response.json())
            .then(data => {
                dispatch(newDispenser({ id: data.id, flow_volume: data.flow_volume }));
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }
    return (
        <div className='flex items-center justify-center'>
            <button onClick={createDispenser} className='cursor-pointer focus:outline-none text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800'> Create new dispenser </button>
        </div>
    )
}
