import React, { Component } from 'react';

import { Link } from 'react-router-dom';


class Account extends Component {

    constructor(props) {
        super(props);
        this.state = {
            createAccountRequest : {
                customerId: '',
                initialCredit: 0
            }
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        console.log(this.props.match.params.id)
        this.setState({
            createAccountRequest : {
                customerId: this.props.match.params.id,
                initialCredit: 0
            }})
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {createAccountRequest} = this.state;

        await fetch('/v1/account', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(createAccountRequest),
        });
        this.props.history.push('/');
    }



    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let createAccountRequest = {...this.state.createAccountRequest};
        createAccountRequest[name] = value;
        this.setState({createAccountRequest});
    }


    render(){
        const {createAccountRequest} = this.state;
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="grid gap-6 mb-6 md:grid-cols-2 mt-10 mx-20">
                    <div>
                        <label htmlFor="customerId" className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Customer Id</label>
                        <input
                          type="text"
                          id="customerId"
                          name="customerId"
                          value={createAccountRequest.customerId || ''}
                          className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:border-blue-500"
                          disabled
                                />
                    </div>
                    <div>
                        <label htmlFor="initialCredit" className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Initial Credit</label>
                        <input
                          type="text"
                          id="initialCredit"
                          name="initialCredit"
                          onChange={this.handleChange}
                          value={createAccountRequest.initialCredit}
                          autoComplete="initialCredit"
                          className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:border-blue-500"
                       
                                />
                    </div>
                    <div >
                         <button  type="submit" className='bg-blue-500
                              hover:bg-blue-700
                              text-white 
                               font-bold 
                               py-2 px-4
                               rounded
                               mt-5 border
                              '>Save</button>
                              
                                <Link to="/" className="text-blue-500 hover:underline mx-5">Cancel</Link>
                            </div>
                    </div>
            </form>
        )
    }

}
export default Account;