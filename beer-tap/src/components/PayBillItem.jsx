import React from 'react'

import PropTypes from 'prop-types';
import { useDispatch } from 'react-redux';
import { resetTap } from '../redux/tapSlice';

PayBillItem.propTypes = {
    totalAmount: PropTypes.number.isRequired,
    tapUsages: PropTypes.array.isRequired,
};

export default function PayBillItem({ totalAmount, tapUsages }) {
    const calculateUsageDuration = (openedAt, closedAt) => {
        const start = new Date(openedAt);
        const end = new Date(closedAt);
        const differenceInSeconds = (end - start) / 1000;
        return differenceInSeconds;
    }

    const dispatch = useDispatch();

    return (
        <>
            <div>
                <table className='w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400'>
                    <thead className="text-xs uppercase bg-gray-50 dark:text-gray-400 text-gray-800">
                        <tr>
                            <th scope="col" className="px-6 py-3">
                                Time Opened Tap
                            </th>
                            <th scope="col" className="px-6 py-3">
                                Ammount
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {tapUsages.map((usage, index) => {
                            const differenceInSeconds = calculateUsageDuration(usage.opened_at, usage.closed_at);
                            return (
                                <tr className='bg-white border-b text-gray-800 text-center' key={index}>
                                    <td>{differenceInSeconds > 0 ? differenceInSeconds : 'Closed by empty barrel'}</td>
                                    <td>{(usage.total_spent).toFixed(2)} $</td>
                                </tr>
                            );
                        })}
                        <tr className='bg-white border-b text-gray-800 text-center'>
                            <td>Total</td>
                            <td>{totalAmount}</td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div className='pt-4 place-content-center'>
                <button 
                    type="button" 
                    className="focus:outline-none text-white bg-purple-700 hover:bg-purple-800 focus:ring-4 focus:ring-purple-300 font-medium rounded-lg text-sm px-5 py-2.5 mb-2 dark:bg-purple-600 dark:hover:bg-purple-700 dark:focus:ring-purple-900" 
                    onClick={() => dispatch(resetTap())}>
                        Click here to pay
                </button>
            </div>
        </>
    );
}
