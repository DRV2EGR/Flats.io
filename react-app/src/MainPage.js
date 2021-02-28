import './App.css';
import React, {Component} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';


import AwesomeSlider from 'react-awesome-slider';
import 'react-awesome-slider/dist/styles.css';

import './MainPage.css';


import Header from './Header';

class MainPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            flats: [],
            slideIndex: 1,
            //code: props.code ? props.code : '999',
            //description: props.description ? props.description : 'Unknown error'
        };

        this.renderFlats = this.renderFlats.bind(this);
    }



    async getRandomFlats() {
        return await fetch(`/api/service/flats`)
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

            let id = this.state.flats[i].id;

            let images = this.state.flats[i].images;
            let mappedImgs = images.map((image) =>
                <div data-src={image} key={Math.random()} />
            );



            userList.push(
                <div className='card col m-1'>
                    <AwesomeSlider animation="cubeAnimation">
                        {mappedImgs}
                    </AwesomeSlider>
                    <a href={id}  className='main-a'>
                        <div className='my-div'>
                            <h3>{price}</h3>

                            <p>Улица: {street} <br />
                            Дом: {houseNom}</p>
                        </div>
                    </a>
                </div>

            );
        }

        return userList;
    }

    render() {
        const { flats } = this.state;

        return (
            <div>
                <Header/>

                {/*<AwesomeSlider animation="cubeAnimation">*/}
                {/*    <div data-src="/path/to/image-0.png" />*/}
                {/*    <div data-src="/path/to/image-1.png" />*/}
                {/*    <div data-src="/path/to/image-2.jpg" />*/}
                {/*</AwesomeSlider>*/}




                <div className='page-wrap d-flex flex-row align-items-center m-3'>
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