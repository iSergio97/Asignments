import { configureStore } from "@reduxjs/toolkit";
import tapReducer from "./tapSlice";

export const store = configureStore({
    reducer: {
        tap: tapReducer,
    }
});