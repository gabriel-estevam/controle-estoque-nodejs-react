import React, { useEffect } from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import Login from '../pages/Login';
import { Home } from '../pages/Home';
import { Dashboard } from '../pages/Dashboard/Dashboard';
import { useDrawerContext } from '../contexts/DrawerContext';

// @ts-ignore
const PrivateRoute = ({ children, redirectTo }) => {
    const isAuthenticated = localStorage.getItem("token") !== null;
    console.log("isAuth: ", isAuthenticated);
    return isAuthenticated ? children : <Navigate to={redirectTo} />;
  };

export const AppRoutes = () => {
    
    const { setDrawerOptions } = useDrawerContext();
    useEffect(() => {
      setDrawerOptions([
        {
          path: '/home',
          label: 'Home',
        },
      ]);
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    return (
        <Routes>
            <Route path="/home" 
                  element={<PrivateRoute redirectTo="/">
                                <Home>
                                    <Dashboard/>
                                </Home>
                           </PrivateRoute>
                  } />
            <Route path="/login" element={<Login/>} />
            <Route path="*" element={<Navigate to="/login" />} />
        </Routes>
    );
}