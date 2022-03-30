module.exports = {
  parser: 'babel-eslint',
  extends: ['@react-native-community', 'prettier'],
  plugins: ['flowtype', 'prettier'],
  rules: {
    'max-len': 'off',
    'prettier/prettier': [
      2,
      {
        singleQuote: true,
        printWidth: 140
      }
    ]
  }
};
