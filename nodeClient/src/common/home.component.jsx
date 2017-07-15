import React, { Component } from 'react';
import SearchBar from './home/search-bar.component.jsx';
import SearchResults from './home/search-results.component.jsx';

class Home extends Component {
    constructor() {
        super();
        this.state = {
            searchText: '',
            socialRecord: ''
        };
        this.gotResults = this.gotResults.bind(this);
        this.displayResults = this.displayResults.bind(this);
        console.log(window.currentWallet);
    }

    gotResults(error, socialRecord) {
        // do something 
        if (error) {
            this.setState({ errorMessage: error });
        } else {
            this.setState({ socialRecord });
            this.displayResults();
        }
    }

    displayResults() {
        if (this.state.socialRecord) {
            return (<SearchResults socialRecord={ this.state.socialRecord }/>);
        } else {
            return (<SearchResults error={ this.state.errorMessage }/> );
        }
    }

    render(){
        return (
            <div className="animated fadeInUp" id="search-box-container">
                <div className="row">
                    <div className="col-xs-12 col-sm-8 col-md-8 col-lg-8 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
                        <SearchBar searchCallback={ this.gotResults }/>
                        <hr />
                        {this.displayResults()}
                    </div>
                </div>
            </div>
        );
    }
}

export default Home