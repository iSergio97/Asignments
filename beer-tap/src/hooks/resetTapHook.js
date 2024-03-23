import { useDispatch } from "react-redux";

const useResetTap = () => {
    const dispatch = useDispatch();
    const resetTapHandle = () => {
        dispatch(dispatch(resetTap()));
    }

    return resetTapHandle
}