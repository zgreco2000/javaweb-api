import React, { Component } from 'react';
import './App.css';
import Header from './components/Header';
import Form from './components/Form';
import List from './components/List';
import Footer from './components/Footer';

// const API_KEY = '7dcd63073a1ec66fc4293ac23b73aa5d';

class App extends Component {

  state = {
    items: []
  }

  getWeather = async (e) => {

    e.preventDefault();
    // const api_call = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=${API_KEY}`);
    //const api_call = await fetch(`http://localhost:3000/data.json`);
    //const nombre = e.target.getElementsByTagName('input')[0].value;
    const nombre = e.target.elements.bnombre.value;

    let api_call;
    if(nombre===""){
      api_call = await fetch(`http://localhost:8080/ws-rest-server/api/productos`);
    }else {
      api_call = await fetch(`http://localhost:8080/ws-rest-server/api/productosfiltros/`+nombre);
    }
      
    const data = await api_call.json();
    // console.log(data);
    this.setState(
      {
        items: data
      }
    );
  }

  deleteItem = async (itemId) => {
    if(!window.confirm('Desea eliminar el item')) {
      return false
    }
    const filteresItems = this.state.items.filter(x => x.id !== itemId);
    console.log('lista filtrada');
    this.setState({
      items : filteresItems
    });

    var xhr = new XMLHttpRequest();
    xhr.open('DELETE', 'http://localhost:8080/ws-rest-server/api/productos/'+itemId);
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    xhr.send();
  }

  render() {

    return (

      <div>
        <Header></Header>          
        <div className="container">
          <Form 
              getWeather={this.getWeather}>
          </Form>
          <List 
              items={this.state.items} 
              deleteItem={this.deleteItem}>
          </List>
        </div>
        <Footer></Footer>
      </div>
    );
  }
}

export default App;