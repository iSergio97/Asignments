import { useCallback } from 'react'; 

const useFillGlass = () => {
    const fillGlass = useCallback((id) => {
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
    }, []);

    return fillGlass;
}

export default useFillGlass;