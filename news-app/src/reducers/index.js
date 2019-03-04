import { combineReducers } from 'redux'
import {
  REQUEST_NEWS,
  RECEIVE_NEWS,
  REQUEST_POP_NEWS,
  RECEIVE_POP_NEWS,
  SAVE_RATING,
  SAVE_RATING_SUCCESS
} from '../actions'


function allNews(state = {}, action) {
  switch (action.type) {
    case REQUEST_NEWS:
    return Object.assign({}, state, {
      isFetching: true
    })
    case RECEIVE_NEWS:
    return Object.assign({}, state, {
      isFetching: false,
      items: action.newsItems,
      lastUpdated: action.receivedAt
    })
    default:
      return state
  }
}

function popNews(state = {}, action) {
  switch (action.type) {
    case REQUEST_POP_NEWS:
      return Object.assign({}, state, {
        isFetching: true
      })
    case RECEIVE_POP_NEWS:
      return Object.assign({}, state, {
        isFetching: false,
        items: action.newsItems,
        lastUpdated: action.receivedAt
      })
    default:
      return state
  }
}

function ratingReducer(state = {}, action) {
  switch (action.type) {
    case SAVE_RATING:
      return Object.assign({}, state, {
        isSaving: true,
        data: {}
      })
    case SAVE_RATING_SUCCESS:
      return Object.assign({}, state, {
        isSaving: false,
        data: action.data
      })
    default:
      return state
  }
}

const rootReducer = combineReducers({
  allNews,
  popNews,
  ratingReducer
})

export default rootReducer