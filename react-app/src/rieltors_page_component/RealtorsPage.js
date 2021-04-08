//ToDo: RealtorsPage.js
import React, {Component} from 'react';
import Cookies from "universal-cookie";
import Header from "../Header";
import './RealtorPage.css';
import {Preloader, TailSpin} from "react-preloader-icon";

class RealtorsPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            page : [],
            summa : 0,
            loading : true,
            ishidden : 'hidden'
        }
    }

    async getAllRieltors(credentials) {
        return await fetch('/api/user/public/get_all_realtors', {
            method: 'get',
            headers: new Headers({
                'Content-Type': 'application/json'
            }),
            body:JSON.stringify(credentials)
        }).then(response => {
            if (!response.ok) {
                // this.checkValidRefresh();
                window.location.reload();
            }
            return response.json();
        });
    }

    async getUserAwatar(username) {

        return await fetch('/api/user/public/get_user_img_url_by_username?username=' + username, {
            method: 'get',
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        }).then(response => {
            if (!response.ok) {
                // this.checkValidRefresh();
                //window.location.reload();
            }
            return response.json();
        });
    }



    async componentDidMount() {
        const lemma = [];

        await this.getAllRieltors().then(async (res) => {

            this.setState({
                summa:res.length
            });

            for (let i = 0; i < res.length; ++i) {
                await this.getUserAwatar(res[i].username).then(img_url => res[i].img_url = img_url)

                await console.log(res[i]);

                let erase = [];
                if (res[i].img_url.img == "") {
                    await erase.push(
                        <div>
                            <img src='https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg'
                            className='realtor-avatar poabs' />
                            <div className='realtor-avatar-div'>
                                <span className='realtor-avatar-letter'>
                                    {res[i].firstName.charAt(0)}
                                </span>
                            </div>
                        </div>
                    );
                } else {
                    await erase.push(
                        <img src={res[i].img_url.img} className='realtor-avatar' />
                    );
                }

                await lemma.push(
                    // <div>
                    //     {res[i].firstName}
                    // </div>
                    <a href={'/user/'+res[i].id}>
                        <div className='realtor-container'>
                            <div className='realtor-credentials tap-realtor-peace'>
                                <div className='realtor-avatar-container'>
                                    {erase}
                                </div>
                                <div>
                                    <span className='realtor-fio-cred'>{res[i].firstName} {res[i].secondName}</span>

                                    <div className='realtor-fio-descr'>
                                        {res[i].role}
                                    </div>
                                    <div className='realtor-fio-descr'>
                                        на сайте с: янв. 2014
                                    </div>
                                </div>

                            </div>
                            <div className='realtor-review tap-realtor-peace dff'>
                                <ui>
                                    <li>X.Y</li>
                                    <li className='df'>
                                        <svg data-name="Star" xmlns="http://www.w3.org/2000/svg" width="100%" height="100%" viewBox="0 0 20 18">
                                            <defs>
                                                <linearGradient id="12596888-0" y2="0%" x2="100%" y1="0%" x1="0%">
                                                    <stop offset="0%" stop-opacity="1" stop-color="#ff7e00"></stop>
                                                    <stop offset="100%" stop-opacity="1" stop-color="#ff7e00"></stop>
                                                    <stop offset="100%" stop-opacity="0" stop-color="#ff7e00"></stop>
                                                    <stop offset="100%" stop-opacity="1" stop-color="#ff7e00"></stop>
                                                    <stop offset="100%" stop-opacity="1" stop-color="#ff7e00"></stop>
                                                </linearGradient>
                                            </defs>
                                            <path stroke="url(#12596888-0)" fill="url(#12596888-0)" d="M15.214 17.176l-.996-5.805 4.218-4.112-5.83-.847L10 1.13 7.393 6.412l-5.83.847 4.219 4.112-.996 5.805L10 14.436l5.214 2.74z">

                                            </path>
                                        </svg>
                                    </li>

                                    <li>
                                        <svg data-name="Star" xmlns="http://www.w3.org/2000/svg" width="100%" height="100%" viewBox="0 0 20 18">
                                            <defs>
                                                <linearGradient id="12596888-3" y2="0%" x2="100%" y1="0%" x1="0%">
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="0" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="100%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                </linearGradient>
                                            </defs>
                                            <path stroke="url(#12596888-3)" fill="url(#12596888-3)" d="M15.214 17.176l-.996-5.805 4.218-4.112-5.83-.847L10 1.13 7.393 6.412l-5.83.847 4.219 4.112-.996 5.805L10 14.436l5.214 2.74z">

                                            </path>
                                        </svg>
                                    </li>

                                    <li>
                                        <svg data-name="Star" xmlns="http://www.w3.org/2000/svg" width="100%" height="100%" viewBox="0 0 20 18">
                                            <defs>
                                                <linearGradient id="12596888-3" y2="0%" x2="100%" y1="0%" x1="0%">
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="0" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="100%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                </linearGradient>
                                            </defs>
                                            <path stroke="url(#12596888-3)" fill="url(#12596888-3)" d="M15.214 17.176l-.996-5.805 4.218-4.112-5.83-.847L10 1.13 7.393 6.412l-5.83.847 4.219 4.112-.996 5.805L10 14.436l5.214 2.74z">

                                            </path>
                                        </svg>
                                    </li>

                                    <li>
                                        <svg data-name="Star" xmlns="http://www.w3.org/2000/svg" width="100%" height="100%" viewBox="0 0 20 18">
                                            <defs>
                                                <linearGradient id="12596888-3" y2="0%" x2="100%" y1="0%" x1="0%">
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="0" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="100%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                </linearGradient>
                                            </defs>
                                            <path stroke="url(#12596888-3)" fill="url(#12596888-3)" d="M15.214 17.176l-.996-5.805 4.218-4.112-5.83-.847L10 1.13 7.393 6.412l-5.83.847 4.219 4.112-.996 5.805L10 14.436l5.214 2.74z">

                                            </path>
                                        </svg>
                                    </li>

                                    <li>
                                        <svg data-name="Star" xmlns="http://www.w3.org/2000/svg" width="100%" height="100%" viewBox="0 0 20 18">
                                            <defs>
                                                <linearGradient id="12596888-3" y2="0%" x2="100%" y1="0%" x1="0%">
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="0" stop-color="#e8e9ec"></stop>
                                                    <stop offset="0%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                    <stop offset="100%" stop-opacity="1" stop-color="#e8e9ec"></stop>
                                                </linearGradient>
                                            </defs>
                                            <path stroke="url(#12596888-3)" fill="url(#12596888-3)" d="M15.214 17.176l-.996-5.805 4.218-4.112-5.83-.847L10 1.13 7.393 6.412l-5.83.847 4.219 4.112-.996 5.805L10 14.436l5.214 2.74z">

                                            </path>
                                        </svg>
                                    </li>
                                </ui>
                                <div>
                                    <span className='review-count-text'>m отзывов</span>
                                </div>
                            </div>
                            <div className='realtor-objects tap-realtor-peace'>
                                <div>
                                    <span className='nomber-of-objects-big'>N объектов</span> <br />
                                    <span style={{marginLeft : '10px'}}>в работе</span>
                                </div>
                            </div>
                        </div>
                    </a>
                );

                // console.log('pushed');
            }

            // console.log(lemma);
        });

        this.setState(
            {page : lemma}
        );


        // let user = await this.getUser({username});
        // this.setState({
        //     firstName: user.firstName,
        //     secondName: user.secondName,
        //     lastName: user.lastName,
        //     email: user.email,
        //     phoneNumber: user.phoneNumber,
        //     role: user.role
        // });
        //
        // await this.getUserAwatar().then(res => this.setState({
        //     awatar_rieltor:res.img
        // }))
        //
        // if (this.state.awatar_rieltor === '') {
        //     this.setState({
        //         awatar_rieltor:'https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg'
        //     });
        // }
        //
        // this.setState({main_container:'container-main', loading:false})
        this.setState({
            loading:false,
            ishidden:''
        });
    }

    render() {
        const {page, summa, loading, ishidden} = this.state;

        return (
            <div>
                <Header />

                {loading ? <div className='m-md-auto cent'><Preloader
                    use={TailSpin}
                    size={200}
                    strokeWidth={6}
                    strokeColor="#262626"
                    duration={2000}
                /></div> : <div></div>}

                    <div className={ishidden}>
                    <h3>Риелторы для вас</h3>
                    <span className='summary'>Найдено {summa} риелторов</span>
                    <br /><br />
                    <div className='main-container'>


                        {page}

                    </div>
                </div>

            </div>
        );
    }
}

export default RealtorsPage;