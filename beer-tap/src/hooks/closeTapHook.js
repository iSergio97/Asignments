import { useCallback } from 'react';
import { useDispatch } from 'react-redux';
import { closeTap } from '../redux/tapSlice';

const useCloseTap = () => {
    const dispatch = useDispatch();

    const closeTapHandle = useCallback((id) => {
        const REACT_APP_API_PATH = process.env.REACT_APP_API_PATH;

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
    }, [dispatch]);

    return closeTapHandle;
}

export default useCloseTap;