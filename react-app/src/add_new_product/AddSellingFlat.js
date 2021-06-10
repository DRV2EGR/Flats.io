// TODO: AddSellingFlat.js

import React, {Component, useState} from "react";
import './AddSellingFlat.css';
import {Fab, FormHelperText, Input, InputLabel, makeStyles, Typography, withStyles} from "@material-ui/core";
import * as PropTypes from "prop-types";
import NavigationIcon from '@material-ui/icons/Navigation';
import {WithStyles} from "@material-ui/core/styles/withStyles";
import transitions from "@material-ui/core/styles/transitions";
import Grid from "@material-ui/core/Grid";
import {Label} from "@material-ui/icons";
import Header from "../Header";
import FormControl from "react-bootstrap/lib/FormControl";
import {Form} from "formik";
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import Link from "@material-ui/core/Link";
import CssBaseline from "@material-ui/core/CssBaseline";
import Container from "@material-ui/core/Container";
import CurrencyInput from 'react-currency-input-field';
import CurrencyTextField from '@unicef/material-ui-currency-textfield'
import './UploadPhotoComponent'

import {AddressSuggestions} from 'react-dadata';
import 'react-dadata/dist/react-dadata.css';

import {green, purple} from '@material-ui/core/colors';
import UploadPhotoComponent from "./UploadPhotoComponent";
import {DropzoneArea} from "material-ui-dropzone";
import Cookies from "universal-cookie";

import NumericInput from 'react-numeric-input';

const useStyles = (theme) => ({
    margin: {
        margin: theme.spacing(5),
    },
    extendedIcon: {
        marginRight: theme.spacing(1),
    },
    form: {
        width: '100%', // Fix IE 11 issue.
        marginTop: theme.spacing(3),
        htmlFontSize: 10,
    },
    submit: {
        margin: theme.spacing(3, 0, 2),
    },
    floor: {
        height: '50px',
        width: '150px',
        fontSize: 'xx-large',
    }
});

class AddSellingFlat extends Component {

    constructor(props) {
        super(props);
        this.state = {
            currentChoseMenuStyle: 'b-popup',
            address: '',
            files: [],
            file_urls: []
        };

        this.handleChoseVariantSale = this.handleChoseVariantSale.bind(this);
        this.handleChoseVariantSRent = this.handleChoseVariantSRent.bind(this);

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleReset = this.handleReset.bind(this);

        this.onChangeAdress = this.onChangeAdress.bind(this);

        this.handleSubmission = this.handleSubmission.bind(this);
    }

    handleChoseVariantSale() {
        this.setState({currentChoseMenuStyle: 'b-popup-hidden', variant: 'Выставить на продажу'})
    }

    handleChoseVariantSRent() {
        this.setState({currentChoseMenuStyle: 'b-popup-hidden', variant: 'Сдать в аренду'})
    }

    handleSubmit = async e => {
        e.preventDefault();
    }

    handleReset = async e => {
        e.preventDefault();
    }

    handleChange = address => {
        this.setState({address});
    };

    // async sendRequestToPostOrder(credentials) { //credentials as param
    //     await console.log('data', credentials);
    //     const _credentials = await JSON.stringify(credentials);
    //     console.log(_credentials);
    //
    //     const cookies = new Cookies();
    //     let a = cookies.get('accessToken');
    //
    //     let data = '';
    //     return await fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/flats/add_flat', {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json',
    //             'Authorization': 'Bearer ' + a
    //         },
    //         body: _credentials
    //     })
    //         .then(data => data.json())
    // }

    onChangeAdress(suggestion) {
        // console.log(suggestion);
        this.setState({
            country: suggestion.data.country,
            town: suggestion.data.city,
            street: suggestion.data.street,
            houseNom: suggestion.data.house
            //TODO: добавить корпуса и прочее
        });
    }

    async handleSubmission() {
        const FIELD = 'secure_url';
        const PROMISES = await this.state.files.map(file => {
            const formData = new FormData();
            formData.append('file', file);
            formData.append('upload_preset', 'fxqt4ulu');

            return fetch(process.env.REACT_APP_BASE_BACKEND_URL + 'https://api.cloudinary.com/v1_1/drv2vna/upload', {
                method: 'POST',
                body: formData
            })
            .then(response => response.json())
            .then(data => data[FIELD]);
        });

        Promise.all(PROMISES)
        .then(file_urls => this.setState({ file_urls: file_urls}))
        .then(() => {
            const cookies = new Cookies();

            const {country, town, street, houseNom, floor, price, description} = this.state;

            const USERNAME = cookies.get('username');
            const flatsImages = this.state.file_urls;
            let forSale = false;
            let forRent = false;

            if (this.state.variant == "Выставить на продажу") {
                forSale = true;
            } else if (this.state.variant == "Сдать в аренду") {
                forRent = true;
            }

            const credentials = {
                country,
                town,
                street,
                houseNom,
                floor,
                price,
                description,
                forSale,
                forRent,
                USERNAME,
                flatsImages
            };

            fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/flats/add_flat', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + cookies.get('accessToken')
                },
                body: JSON.stringify(credentials)
            })
                .then(data => data.json())
                .then(result => this.setState({res: result.username}))
        });
    }

    // // Обработка файлов в файлохранилище
    // async _handleSubmission() {
    //     //for (let i = 0; i < this.state.files.length; i++) {
    //     for await (const file of this.state.files) {
    //         let xhr = await new XMLHttpRequest();
    //         // xhr.addEventListener('load', () => {
    //         //     // update the state of the component with the result here
    //         //     let resp = JSON.parse(xhr.responseText);
    //         //     this.state.file_urls.push(resp.secure_url);
    //         // })
    //
    //         await xhr.open('POST', 'https://api.cloudinary.com/v1_1/drv2vna/upload');
    //
    //         xhr.onload = async () => {
    //             let resp = await JSON.parse(xhr.responseText);
    //             await this.state.file_urls.push(resp.secure_url);
    //         };
    //
    //         let formData = await new FormData();
    //         await formData.append('file', file);
    //         //(this.state.files[i])
    //         // console.log(i + ' - ' + this.state.files[i])
    //         await formData.append('upload_preset', 'fxqt4ulu');
    //
    //         await xhr.send(formData);
    //     }
    //
    //     console.log(this.state.file_urls);
    //
    //     const cookies = new Cookies();
    //
    //     // let country=this.state.country;
    //     // let town=this.state.town;
    //     // let street=this.state.street;
    //     // let houseNom=this.state.houseNom;
    //     // let floor=this.state.floor;
    //     // let price=this.state.price;
    //     // let description=this.state.description;
    //
    //     let {country,town,street,houseNom,floor,price,description} = this.state;
    //
    //     let username=cookies.get('username');
    //     let flatsImages=this.state.file_urls;
    //
    //     // const test = {}; // Object
    //     // test.a = 'test';
    //     // test.b = []; // Array
    //     // test.b.push('item');
    //     // test.b.push('item2');
    //     // test.b.push('item3');
    //     // test.b.item4 = "A value"; // Ignored by JSON.stringify
    //     // const json = JSON.stringify(test);
    //     // console.log(json);
    //
    //     let forSale = false;
    //     let forRent = false;
    //
    //     if (this.state.variant == "Выставить на продажу") {
    //         forSale = true;
    //     } else if (this.state.variant == "Сдать в аренду") {
    //         forRent = true;
    //     }
    //
    //     // console.log(this.state.file_urls);
    //     const token = await this.sendRequestToPostOrder({
    //         country,
    //         town,
    //         street,
    //         houseNom,
    //         floor,
    //         price,
    //         description,
    //         forSale,
    //         forRent,
    //         username,
    //         flatsImages
    //     }).then(result => {this.setState({res : result.username} ) } )
    //
    // }

    // doCompletefetch(process.env.REACT_APP_BASE_BACKEND_URL + ) {
    //
    //     // "country":"TestCountry",
    //     // "town":"TestTown",
    //     // "street":"моя улица",
    //     // "houseNom":25,
    //     // "floor":7,
    //     // "price":8520000,
    //     // "description":"оыыщуаоыщуащыущашыащшыуоащыоуащшыоущаоытумшмшаыиураиуаишыуми",
    //     // "ForSale":true,
    //     // "ForRent":false,
    //     // "username":"john_the_admin"
    //     // "flatsImages": [
    //     //     "1",
    //     //     "2",
    //     //     "3"
    //     // ]
    //
    //     console.log(this.state.file_urls);
    //
    //     const cookies = new Cookies();
    //
    //     let country = this.state.country;
    //     let town = this.state.town;
    //     let street = this.state.street;
    //     let houseNom = this.state.houseNom;
    //     let floor = this.state.floor;
    //     let price = this.state.price;
    //     let description = this.state.description;
    //
    //     let username = cookies.get('username');
    //     let flatsImages = this.state.file_urls;
    //
    //     // const test = {}; // Object
    //     // test.a = 'test';
    //     // test.b = []; // Array
    //     // test.b.push('item');
    //     // test.b.push('item2');
    //     // test.b.push('item3');
    //     // test.b.item4 = "A value"; // Ignored by JSON.stringify
    //     // const json = JSON.stringify(test);
    //     // console.log(json);
    //
    //     let forSale = false;
    //     let forRent = false;
    //
    //     if (this.state.variant == "Выставить на продажу") {
    //         forSale = true;
    //     } else if (this.state.variant == "Сдать в аренду") {
    //         forRent = true;
    //     }
    //
    //     // console.log(this.state.file_urls);
    //     const token = this.sendRequestToPostOrder({
    //         country,
    //         town,
    //         street,
    //         houseNom,
    //         floor,
    //         price,
    //         description,
    //         forSale,
    //         forRent,
    //         username,
    //         flatsImages
    //     }).then(result => {
    //         this.setState({res: result.username})
    //     })
    // }

    render() {
        const {classes} = this.props;
        const {currentChoseMenuStyle} = this.state;
        const {variant} = this.state;

        return (
            <div>
                <Header/>

                {/*<div className='b-container'>*/}
                {/*    Sample Text*/}
                {/*</div>*/}
                <Container maxWidth="false">
                    <form className={classes.form} noValidate>
                        <Typography variant='h2'>{variant}</Typography>

                        <br/>

                        <Typography variant='h6'>Введите адрес</Typography>
                        <AddressSuggestions token="a18978f22558055e59462541d6f1d382ea5bee9a"
                                            value="Введите адрес"
                                            onChange={this.onChangeAdress}/>
                        {/*<TextField*/}
                        {/*    id="standard-textarea"*/}
                        {/*    label="Этаж"*/}
                        {/*    onChange={this._handleChangeFloor}*/}
                        {/*    placeholder="Введите этаж"*/}
                        {/*/>*/}

                        <br/>
                        <NumericInput
                            id="standard-textarea"
                            label="Этаж"
                            placeholder="Введите этаж"
                            className={classes.floor}
                            onChange={(event, value) => this.setState({floor: value})}
                        />

                        <br/>
                        <br/>
                        {/*<Typography variant="subtitle1" gutterBottom={true}>GBP £</Typography>*/}
                        <CurrencyTextField
                            label="Цена"
                            variant="outlined"
                            placeholder="Введите стоимость"
                            currencySymbol="Руб"
                            onChange={(event, value) => this.setState({price: value})}
                        />

                        <br/><br/><br/>
                        <TextField
                            id="outlined-textarea"
                            label="Описание"
                            multiline
                            fullWidth
                            placeholder="Введите описание квартиры"
                            variant="outlined"
                            onChange={(e) => this.setState({description: e.target.value})}
                        />

                        <br/>
                        <br/>
                        <DropzoneArea
                            acceptedFiles={['image/*']}
                            dropzoneText={"Перетащите сюда изображения или нажмите для выбора"}
                            filesLimit={15}
                            onChange={(images) => {
                                this.setState({files: images});
                            }}
                        />

                        <Grid container justify="center" spacing={2}>
                            <Button
                                // type="submit"
                                onClick={this.handleSubmission}
                                variant="contained"
                                color="green"
                                className={classes.submit}
                            >
                                Разместить объявление!

                            </Button>
                        </Grid>
                    </form>
                </Container>

                {/* Всплывающее окно */}
                <div className={currentChoseMenuStyle}>
                    <div className='b-popup-content'>

                        {/*Text in Popup*/}

                        <div className='intrance-form'>
                            <Grid container justify="center" spacing={2}>
                                <Typography variant="h3">Выберите тип объявления:</Typography>
                                <Grid container justify="center" spacing={2}>
                                    <Fab variant="extended" color="#ffffff" aria-label="add" className={classes.margin}
                                         onClick={this.handleChoseVariantSale}>
                                        <NavigationIcon className={classes.extendedIcon}/>
                                        Выставить на продажу
                                    </Fab>
                                    <Fab variant="extended" color="primary" aria-label="add" className={classes.margin}
                                         onClick={this.handleChoseVariantSRent}>
                                        <NavigationIcon className={classes.extendedIcon}/>
                                        Сдать в аренду
                                    </Fab>
                                </Grid>
                            </Grid>
                        </div>

                    {/*    POPUP END    */}
                    </div>
                </div>

            </div>
        );
    }

}

export default withStyles(useStyles)(AddSellingFlat);