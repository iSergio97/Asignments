import React from 'react'
import { useSelector } from 'react-redux';
import CloseTap from './CloseTap';
import FillGlass from './FillGlass';
import PayBill from './PayBill';

export default function Tap() {
    const tap = useSelector(state => state.tap);
    const { amount } = tap;


    return (
        <>
            {amount === 0 ?
                <>
                    <FillGlass />
                    <CloseTap />
                </> :
                <PayBill />
            }
        </>
    )
}
