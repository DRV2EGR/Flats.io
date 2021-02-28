import './App.css';
import React, {Component, useRef} from 'react';
import Cookies from "universal-cookie";

function getUserAvatar() {
    const cookies = new Cookies();
    let a = cookies.get('accessToken');
    let b = cookies.get('username');
    console.log(b)

    return fetch('/api/user/get_user_img_url_by_username?username=' + b, {
        method: 'post',
        headers: new Headers({
            'Authorization': 'Barer ' + a,
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(cookies.get('username'))
    });
}

class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data_p: '',
            userhref: '/login',
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        };
    }

    componentDidMount() {

        //TODO: вставить получение картинки.
        // fetch('/api/user/get_user_img_url?userId=22' )
        //     .then(response => response.json())
        //     .then(res => /*console.log(result.imgUrl) );*/ this.setState({data_p : res.img}));
        //
        // console.log(this.state.data_p);
    // .catch(e => {
    //         console.log(e);
    //         this.setState({data: result, isFetching: false, error: e }));
    // });

        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let b = cookies.get('username');

        if (b) {
            this.setState({userhref: 'user_cabinet'});
        }


        //console.log(b)

        fetch('/api/user/get_user_img_url_by_username?username=' + b, {
            method: 'post',
            headers: new Headers({
                'Authorization': 'Barer ' + a,
                'Content-Type': 'application/json'
            }),
            body: JSON.stringify(cookies.get('username'))
        }) .then(response => response.json())
            .then(res => /*console.log(result.imgUrl) );*/ this.setState({data_p : res.img}));

    }

    addFunctions() {
        const cookies = new Cookies();
        let b = cookies.get('username');

        if (b) { //войдено
            return (
            <div className="dropdown-child">
                <a href="/user_cabinette">Мой кабинет</a>
                <a href="/add_order">Разместить объявление</a>
                <a href="/user_settings">Настройки</a>
                <a href="/logout">Выйти</a>
            </div>
            )
        }

    }

    render() {
        const { data_p } = this.state;
        const { userhref } = this.state;

        return (
            <div>
                <div className='d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm'>
                    <h5 className='my-0 mr-md-auto font-weight-bold'><a className='p-2 text-dark' href='/'>Flats.io</a></h5>

                    <nav className='my-2 my-md-0 mr-md-3'>
                        {/*<a className='p-2 text-dark' href='/user/1'>Личный кабинет</a>*/}
                        <a className='p-2 text-dark' href='/rieltors'>Риелторы</a>
                        <a className='p-2 text-dark' href='/about'>О нас</a>

                        {/*<a href={userhref} >*/}
                        {/*    <img className='user-nav-img' src={data_p} />*/}

                        {/*</a>*/}

                        <div className="dropdown">
                            <div >
                                <img className='user-nav-img' src={data_p} />

                            </div>
                            { this.addFunctions() }
                        </div>
                    </nav>
                    {/*<a className='btn btn-outline-primary' href='/#'>Выход</a>*/}

                </div>
            </div>
        );
    }

}

export default Header;