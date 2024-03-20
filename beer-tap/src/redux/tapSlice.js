import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    id: "",
    flow_volume: 0,
    status: "",
    amount: 0,
    usages: [
        {
            opened_at: null,
            closed_at: null,
            flow_volume: null,
            total_spent: null
        }
    ]
};

export const tapSlice = createSlice({
    name: "tap",
    initialState,
    reducers: {
        newDispenser: (state, action) => {
            const { id, flow_volume } = action.payload;
            state.id = id;
            state.flow_volume = flow_volume;
        },
        openTap: (state, action) => {
            state.status = "open";
        },

        closeTap: (state, action) => {
            const { amount, usages } = action.payload;
            state.status = "close";
            state.amount = amount;
            // TODO: Fix set usages on tap
            state.usages = usages;
        },
    }
});


/* eslint-disable */
export const { newDispenser, openTap, closeTap } = tapSlice.actions;

export default tapSlice.reducer;