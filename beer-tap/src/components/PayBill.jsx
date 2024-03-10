import React from 'react'
import { useSelector } from 'react-redux';

export default function PayBill() {
    const tap = useSelector(state => state.tap);
    const { amount, usages } = tap;
    return (
        <>
            <div>{amount}</div>
            <br />
            <div>{usages}</div>
        </>
    )
}
