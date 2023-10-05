import { Component } from 'react';
import {BrowserRouter as Router,Switch,Route } from 'react-router-dom';
import Customer from './component/Customer';
import Account from './component/Account';



class App extends Component {
      render(){
        return(
          <Router>
            <Switch>
              <Route path='/' exact component={Customer}/>
              <Route path='/account/:id' exact component={Account}/>
           </Switch> 
        </Router>
        )
      }
}

export default App;
