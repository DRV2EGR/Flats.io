import logo from './logo.svg';
import './App.css';
import React, {Component} from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import ErrorPage from './ErrorPage';
import 'bootstrap/dist/css/bootstrap.min.css';
import MainPage from "./main_page_component/MainPage";
import Login from "./login_component/Login";
import SignUP from "./login_component/SignUP";
import UserProfile from "./user_profile_component/UserProfile";
import {withRouter} from "react-router";
import AddSellingFlat from "./add_new_product/AddSellingFlat";
import FlatPage from "./flat_page_component/FlatPage";
import RealtorsPage from "./rieltors_page_component/RealtorsPage";
import AboutPage from "./about_component/AboutPage";

class App extends Component {
  render() {
    return (
        <BrowserRouter>
          <Switch>
              <Route exact path={'/'} component={MainPage}/>

              <Route exact path={'/login'} component={Login}/>

              <Route exact path={'/signup'} component={SignUP}/>

              <Route exact path={'/user_profile'} component={UserProfile}/>
              <Route exact path={'/user/:username'} component={UserProfile}/>

              <Route exact path={'/add_order'} component={AddSellingFlat}/>

              <Route exact path='/flat/:flatId' component={FlatPage}/>

              <Route exact path='/realtors' component={RealtorsPage}/>

              <Route exact path='/about' component={AboutPage}/>


            {/*<Route exact path='/'>*/}
            {/*  <Header/>*/}
            {/*  <Mainpage/>*/}
            {/*</Route>*/}

            {/*<Route exact path='/login'>*/}
            {/*  <Login/>*/}
            {/*</Route>*/}

            {/*
            <Route exact path={'/user/:userId'} component={UserProfile}/>

            <Route exact path='/admin/users' render={props => <AdminUsers{...props}/>}/>

            <Route exact path='/admin/lessons' render={props => <AdminLessons{...props}/>}/>

            <Route exact path='/verdicts'>
              <Header {...this.props}/>
              <VerdictsInfo/>
            </Route>

            <Route exact path='/course/:courseId' component={Course}/>

            <Route exact path='/admin/lessons/new' component={AdminCreateLesson}/>

            <Route exact path='/admin/signup' component={AdminSignup}/>

            <Route exact path='/about-courses'>
              <Header/>
              <AboutCourses/>
            </Route>

            <Route exact path='/course/:courseId/homework/' component={CourseHomework}/>

            <Route exact path='/course/:courseId/homework/:homeworkId'
                   render = {props => <Homework{...props} tab={'description'}/> }/>


            <Route exact path='/course/:courseId/homework/:homeworkId/problems/:problemNumber'
                   render = {props => <Homework{...props} tab={'problems'}/> }/>

            <Route exact path='/course/:courseId/homework/:homeworkId/submissions'
                   render = {props => <Homework{...props} tab={'submissions'}/> }/>

            <Route exact path='/about-statistics' component={AboutStatistics}/>
            */}

            <Route>
              <ErrorPage code={404} description={'Страница не найдена.'}/>
            </Route>

          </Switch>
        </BrowserRouter>
    );
  }

}

export default (App);
