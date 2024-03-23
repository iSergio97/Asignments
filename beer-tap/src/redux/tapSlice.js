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

const tapSlice = createSlice({
    name: "tap",
    initialState,
    reducers: {
        newDispenser: (state, action) => {
            const { id, flow_volume } = action.payload;
            state.id = id;
            state.flow_volume = flow_volume;
        },
        openTap: (state) => {
            state.status = "open";
        },

        closeTap: (state, action) => {
            const { amount, usages } = action.payload;
            state.status = "close";
            state.amount = amount;
            state.usages = usages;
        },
        resetTap: (state) => {
            state.id = '';
            state.flow_volume = 0;
            state.status = '';
            state.amount = 0;
            state.usages = [];
        }
    }
});

/* eslint-disable */
export const { newDispenser, openTap, closeTap, resetTap } = tapSlice.actions;

export default tapSlice.reducer;