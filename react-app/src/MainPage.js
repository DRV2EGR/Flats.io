import './App.css';
import React, {Component} from 'react';

import Header from './Header';

class MainPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            flats: [],
            //code: props.code ? props.code : '999',
            //description: props.description ? props.description : 'Unknown error'
        };

        this.renderFlats = this.renderFlats.bind(this);
    }



    async getRandomFlats() {
        return await fetch(`http://localhost:3000/api/service/flats`)
            .then(data => data.json());

        // //console.log(res.json());
        //const data = await res.json();
        // //console.log(data)
        //return data;
    }

    async componentDidMount() {
        //TODO:
        const _flats = await this.getRandomFlats();
        console.log(_flats);
        this.setState({ flats: [..._flats] });


    }

    renderFlats() {

        const userList = [];

        let k = 0;
        try {
            k = this.state.flats.length;
        } catch (e) {
            k = 0;
        }


        for(let i = 0; i < k; i++) {
            // let name = `${this.state.flats_p[i].name.first} ${this.state.flats_p[i].name.last}`;
            let country = this.state.flats[i].country;
            let town = this.state.flats[i].town;
            let street = this.state.flats[i].street;
            let houseNom = this.state.flats[i].houseNom;
            let floor = this.state.flats[i].floor;
            let price = this.state.flats[i].price;
            let description = this.state.flats[i].description;
            userList.push(
                <div className='my-card col-md-5'> {town} {houseNom} {description} </div>
            );
        }

        return userList;
    }

    render() {
        const { flats } = this.state;

        return (
            <div>
                <Header/>



                <div className='page-wrap d-flex flex-row align-items-center pt-5'>
                    <div className='container'>
                        <div className='row'>
                                    {this.renderFlats()}
                        </div>
                    </div>
                </div>

                {/*<div className='page-wrap d-flex flex-row align-items-center pt-5'>*/}
                {/*    <div className='container'>*/}
                {/*        <div className='row justify-content-center'>*/}
                {/*            <div className='col-md-12 text-center'>*/}
                {/*                <span className='font-weight-bold lead'>Главная страница</span>*/}
                {/*            </div>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                {/*</div>*/}
            </div>
        );
    }
}

export default MainPage;