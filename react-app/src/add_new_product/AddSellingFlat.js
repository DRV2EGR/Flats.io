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

import { AddressSuggestions } from 'react-dadata';
import 'react-dadata/dist/react-dadata.css';

import { green, purple } from '@material-ui/core/colors';
import UploadPhotoComponent from "./UploadPhotoComponent";
import {DropzoneArea} from "material-ui-dropzone";


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
        this.setState({ address });
    };

    sendRequestToPostOrder(credentials) { //credentials as param
        //console.log(JSON.stringify(credentials));

        let data = '';
        return fetch('/api/flats/add_flat', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(credentials)
        })
            .then(data => data.json())
    }

    // Обработка файлов в файлохранилище
    handleSubmission = () => {
        for (let i = 0; i < this.state.files.length; i++) {

            let xhr = new XMLHttpRequest();
            xhr.open('POST', 'https://api.cloudinary.com/v1_1/demo/image/upload');


            xhr.onload = () => {
                let resp = JSON.parse(xhr.responseText);
                this.state.file_urls.push(resp.secure_url)
            };

            let formData = new FormData();
            formData.append('file', this.state.files[i]);
            // console.log(i + ' - ' + this.state.files[i])
            formData.append('upload_preset', 'docs_upload_example_us_preset');

            xhr.send(formData);
        }

            // "country":"TestCountry",
            // "town":"TestTown",
            // "street":"моя улица",
            // "houseNom":25,
            // "floor":7,
            // "price":8520000,
            // "description":"оыыщуаоыщуащыущашыащшыуоащыоуащшыоущаоытумшмшаыиураиуаишыуми",
            // "ForSale":true,
            // "ForRent":false,
            // "username":"john_the_admin"
    };

    render() {
        const { classes } = this.props;
        const { currentChoseMenuStyle } = this.state;
        const { variant } = this.state;

        return (
            <div>
                <Header />

                {/*<div className='b-container'>*/}
                {/*    Sample Text*/}
                {/*</div>*/}
                <Container  maxWidth="false"  >
                    <form className={classes.form} noValidate>
                        <Typography variant='h2'>{variant}</Typography>

                        <br />

                        <Typography variant='h5'>Введите адрес</Typography>
                        <AddressSuggestions token="a18978f22558055e59462541d6f1d382ea5bee9a"
                                            value="Введите адрес"
                                            onChange={ (suggestion) => console.log(suggestion) } />
                        <TextField
                            id="standard-textarea"
                            label="Этаж"
                            placeholder="Введите этаж"
                        />

                        <br />
                        <br />
                            {/*<Typography variant="subtitle1" gutterBottom={true}>GBP £</Typography>*/}
                            <CurrencyTextField
                                label="Цена"
                                variant="outlined"
                                placeholder="Введите стоимость"
                                currencySymbol="Руб"
                                onChange={(event, value)=> console.log(value)}
                            />

                        <br /><br /><br />
                        <TextField
                            id="outlined-textarea"
                            label="Описание"
                            multiline
                            fullWidth
                            placeholder="Введите описание квартиры"
                            variant="outlined"
                        />

                        <br />
                        <br />
                        <DropzoneArea
                            acceptedFiles={['image/*']}
                            dropzoneText={"Перетащите сюда изображения или нажмите для выбора"}
                            filesLimit={15}
                            onChange={(image) => {this.setState({files:image});}}
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
                <div className={currentChoseMenuStyle} >
                    <div className='b-popup-content'>
                        {/*Text in Popup*/}
                        <div className='intrance-form'>
                            <Grid container justify="center" spacing={2}>
                                <Typography variant="h3">Выберите тип объявления:</Typography>
                                <Grid container justify="center" spacing={2}>
                                    <Fab variant="extended" color="#ffffff" aria-label="add" className={classes.margin} onClick={this.handleChoseVariantSale}>
                                        <NavigationIcon className={classes.extendedIcon} />
                                        Выставить на продажу
                                    </Fab>
                                    <Fab variant="extended" color="primary" aria-label="add" className={classes.margin} onClick={this.handleChoseVariantSRent}>
                                        <NavigationIcon className={classes.extendedIcon} />
                                        Сдать в аренду
                                    </Fab>
                                </Grid>
                            </Grid>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export default withStyles(useStyles)(AddSellingFlat);