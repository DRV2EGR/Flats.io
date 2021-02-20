import './App.css';
import React, {Component} from 'react';

import Header from './Header';

class MainPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }
    }

    render() {
        return (
            <div>
                <Header/>

                <div className='page-wrap d-flex flex-row align-items-center pt-5'>
                    <div className='container'>
                        <div className='row justify-content-center'>
                            <div className='col-md-12 text-center'>
                                <span className='font-weight-bold lead'>Главная страница</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default MainPage;