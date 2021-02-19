import './App.css';
import React, {Component} from 'react';

class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error',
            data: null, error: null
        }
    }

    componentDidMount() {
        //TODO: вставить получение картинки.
        fetch('http://localhost:3000/api/user/get_user_img_url' + '?userId=3' )
            .then(response => response.json())
            .then(result => this.setState({data: result }));

        console.log(this.state.data);
    // .catch(e => {
    //         console.log(e);
    //         this.setState({data: result, isFetching: false, error: e }));
    // });
    }



    render() {
        return (
            <div>
                <div className='d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm'>
                    <h5 className='my-0 mr-md-auto font-weight-bold'><a className='p-2 text-dark' href='/'>Flats.io</a></h5>

                    <nav className='my-2 my-md-0 mr-md-3'>
                        {/*<a className='p-2 text-dark' href='/user/1'>Личный кабинет</a>*/}
                        <a className='p-2 text-dark' href='/admin/users'>Риелторы</a>
                        <a className='p-2 text-dark' href='/about'>О нас</a>
                    </nav>
                    {/*<a className='btn btn-outline-primary' href='/#'>Выход</a>*/}

                </div>
            </div>
        );
    }

}

export default Header;