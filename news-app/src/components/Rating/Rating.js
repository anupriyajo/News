import React, { Component } from 'react';
import './style.scss';
import PropTypes from 'prop-types';
import {
    saveRating
} from '../../actions';
import { connect } from 'react-redux';

class Rating extends Component {
  constructor(props, state) {
    super(props);
    this.state = {
      rating: 0
    };
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(nextRating) {
    this.setState({rating: nextRating});
    const { itemId } = this.props;
    // TODO: use dispatch instead of direct function call
    this.props.saveRating({newsId: itemId, rating: nextRating});
  }

  render() {
    const { itemId } = this.props;
    return (
      <div className="rating-wrapper">
        Please rate: 
        <select name={`item-${itemId}`} onChange={e => this.handleChange(e.target.value)}>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
      </div>
    )
  }
}

Rating.propTypes = {
  isSaving: PropTypes.bool.isRequired
 //dispatch: PropTypes.func.isRequired
}

function mapStateToProps(state) {
  const{ ratingReducer } = state;
  const isSaving = ratingReducer.isSaving || true;

  return {
    isSaving
  }
}

export default connect(mapStateToProps, {saveRating})(Rating)