import { useCallback } from "react";
import { useDispatch } from 'react-redux';
import { newDispenser } from '../redux/tapSlice';

const useCreateDispenser = () => {
    const REACT_APP_API_PATH = process.env.REACT_APP_API_PATH;
    const dispatch = useDispatch();

    const createDispenser = useCallback(() => {
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
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            dispatch(newDispenser({ id: data.id, flow_volume: data.flow_volume }));
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }, [REACT_APP_API_PATH, dispatch]);

    return createDispenser;
}

export default useCreateDispenser;