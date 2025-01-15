import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './components/Login';
import Home from './components/Home';

function App() {
  return (
    <Router>
      <Routes>
        {/* Define the route for the login page */}
        <Route path="/login" element={<Login />} />
        
        {/* Define the route for the home page */}
        <Route path="/home" element={<Home />} />

        {/* Optionally, define a default route to redirect */}
        <Route path="*" element={<Login />} /> {/* Redirect unknown paths to login */}
      </Routes>
    </Router>
  );
}

export default App;
