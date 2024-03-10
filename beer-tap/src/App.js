import './App.css';
import { useSelector } from 'react-redux';
import { Dispenser } from './components/Dispenser';

function App() {
  const tap = useSelector(state => state.tap);
  // const { id, status } = tap;
  // let className = id && status === "open" ? "bg-green-500" : "bg-grey-400";

  return (
    <div className='max-w-[700px] fit-info flex items-center justify-center'>
      <Dispenser />
    </div>
  );
}

export default App;
