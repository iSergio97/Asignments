import React from 'react';
import { render } from '@testing-library/react';
import App from '../App';

describe('App', () => {
    it('renders App component', () => {
        render(<App />);
        let appElement = document.querySelector('.max-w-[700px]');
        expect(appElement).toBeInTheDocument();
    });
});
