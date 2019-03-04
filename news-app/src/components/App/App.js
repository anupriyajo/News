import React, { Component } from 'react';
import './style.scss';
import PropTypes from 'prop-types';
import {
  fetchNews,
  fetchPopNews
} from '../../actions';
import { connect } from 'react-redux';
import NewsList from '../../components/NewsList';
import Header from '../../components/Header';

class App extends Component {
  constructor(props) {
    super(props)
  }

  componentDidMount() {
    // TODO: use dispatch instead of direct function call
    this.props.fetchPopNews();
    this.props.fetchNews();
  }

  render() {
    const { newsItems, isFetching, lastUpdated } = this.props;
    const { popNewsItems, isFetchingPopNews, lastUpdatedPopNews } = this.props;
    console.log(this.props);
    return (
      <div className="App">
        <Header />
        <NewsList newsType="Today's top 5" newsItems={this.props.popNewsItems} />
        <NewsList newsType="More..." newsItems={this.props.newsItems} />
      </div>
    );
  }
}

App.propTypes = {
  newsItems: PropTypes.array.isRequired,
  isFetching: PropTypes.bool.isRequired,
  lastUpdated: PropTypes.number
}

function mapStateToProps(state) {
  const { allNews, popNews } = state;
  const isFetching = allNews.isFetching || true;
  const newsItems = allNews.items || [];
  const lastUpdated = allNews.lastUpdated;

  const isFetchingPopNews = popNews.isFetching || true;
  const popNewsItems = popNews.items || [];
  const lastUpdatedPopNews = popNews.lastUpdated;



  return {
    newsItems,
    isFetching,
    lastUpdated,
    isFetchingPopNews,
    popNewsItems,
    lastUpdatedPopNews
  }
}

export default connect(mapStateToProps, {fetchNews, fetchPopNews})(App);
