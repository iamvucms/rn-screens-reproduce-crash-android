module.exports = {
  project: {
    ios: {},
    android: {}
  },
  assets: ['./src/assets/fonts/'],
  dependencies: {
    'tipsi-stripe': {
      platforms: {
        android: null,
        ios: null
      }
    },
    'react-native-video': {
      platforms: {
        android: null
      }
    }
  }
};
