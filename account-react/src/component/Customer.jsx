import React, { Component } from 'react';
import { Link } from 'react-router-dom'; 



class Customer extends Component {

  state = {
    customers: [{
        accounts: [{
                transactions: []
            }]
    }]
};

      async componentDidMount() {
        const response = await fetch('/v1/customer');
        const body = await response.json();
        this.setState({customers: body});
      }   

      render(){
        const {customers} = this.state;
        return (
            <div className='flex flex-col text-3xl  bg-slate-700 text-white p-20 h-full'>
              <div className='mt-10'>
                 <h2 className='text-center text-5xl'>Customers</h2>
              {customers.map(customer =>
                 <div key={customer.id} className='mt-20 flex flex-row items-center justify-around border border-gray-300 rounded p-4 bg-red-900'>
                  <div className='mb-5'>
                    <span className='font-bold'>{customer.name} {customer.surname}</span>
                  </div>
                  <div className='mb-5 '>
                    
                      <button className='bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-2'>
                          <Link to={`/account/${customer.id}`}>
                            Account
                          </Link>
                      </button>
                    
                  </div>
                </div>
              )
              }
              </div>
          </div>
        )
      }
}

export default Customer;