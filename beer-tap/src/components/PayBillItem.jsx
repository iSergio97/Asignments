import React from 'react'

export default function PayBillItem({ totalAmount, tapUsages }) {
    const calculateUsageDuration = (openedAt, closedAt) => {
        const start = new Date(openedAt);
        const end = new Date(closedAt);
        const differenceInSeconds = (end - start) / 1000;
        return differenceInSeconds;
    }

    return (
        <>
            <div>{totalAmount}</div>
            <br />
            {tapUsages.map((usage, index) => {
                const differenceInSeconds = calculateUsageDuration(usage.opened_at, usage.closed_at);
                return (
                    <div key={index}>
                        <div>{usage.closed_at !== null ? `Usage duration: ${differenceInSeconds} seconds` : 'Usage duration closed by an empty barrel'}</div>
                        <div>{usage.total_spent}</div>
                    </div>
                );
            })}
        </>
    );
}
