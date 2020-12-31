import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import ListBoardComponent from './components/ListBoardComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateBoardComponent from './components/CreateBoardComponent';
import ReadBoardComponent from './components/ReadBoardComponent';
import JoinMemberComponent from './components/member/JoinMemberComponent';


function App() {
  return (
    <div> 
      <Router>
        <HeaderComponent/>
          <div className="container">
            <Switch>
              <Route path = "/" exact component = {ListBoardComponent}></Route>
              <Route path = "/board" component = {ListBoardComponent}></Route>
              <Route path = "/create-board/:no" component = {CreateBoardComponent}></Route>
              <Route path = "/read-board/:no" component = {ReadBoardComponent}></Route>
              <Route path = "/member-join" component = {JoinMemberComponent}></Route>
            </Switch>
          </div>

          
        <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;
