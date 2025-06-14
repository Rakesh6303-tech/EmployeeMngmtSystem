import './App.css'
import EmployeeComponent from './components/EmployeeComponent';
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

function App() {
  

  return (
    <>
    <BrowserRouter>
    <HeaderComponent/>
    <Routes>
      {/* // http://localhost:3000 */}
      <Route path='/' element ={ <ListEmployeeComponent/>}></Route>

{/* // http://localhost:3000/Employees */}
<Route path ='/employees' element ={<ListEmployeeComponent/>}></Route>

{/* // http://localhost:3000/add-Employees */}
<Route path = '/add-employee' element = {<EmployeeComponent/>}></Route>

{/* // http://localhost:3000/edit-Employees */}
<Route path = '/edit-employee/:id' element = {<EmployeeComponent/>}></Route>
    </Routes>
      <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App
