import React from 'react';
import { useSelector } from 'react-redux';
import PayBillItem from './PayBillItem';


export default function PayBill() {
    const tap = useSelector(state => state.tap);

    if (!tap) {
        return <div>Loading...</div>;
    }

    const { amount, usages } = tap;

    return <PayBillItem totalAmount={amount} tapUsages={usages} />;
}