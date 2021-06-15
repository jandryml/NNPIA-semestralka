import {Link} from "react-router-dom";
import React, {useEffect, useState} from "react";
import AuthService from "../../services/auth/auth.service";

const Navbar = () => {
    const [showModeratorBoard, setShowModeratorBoard] = useState(false);
    const [showAdminBoard, setShowAdminBoard] = useState(false);
    const [currentUser, setCurrentUser] = useState(null);

    useEffect(() => {
        const user = AuthService.getCurrentUser();
        console.log("Testing user from app")
        console.log(user)

        if (user) {
            setCurrentUser(user);
            setShowAdminBoard(user.roles.includes("ROLE_ADMIN"));
            setShowModeratorBoard(user.roles.includes("ROLE_MODERATOR"));
        }
    }, []);

    const logOut = () => {
        AuthService.logout();
    };

    return (
        <nav className="navbar navbar-expand navbar-dark bg-dark">
            <Link to={"/"} className="navbar-brand">
                Cinema testing
            </Link>
            <div className="navbar-nav mr-auto">
                <li className="nav-item">
                    <Link to={"/home"} className="nav-link">
                        Home
                    </Link>
                </li>

                <li className="nav-item">
                    <Link to={"/film"} className="nav-link">
                        Films
                    </Link>
                </li>

                <li className="nav-item">
                    <Link to={"/cinema"} className="nav-link">
                        Cinemas
                    </Link>
                </li>

                {/*{showAdminBoard && (*/}
                {/*    <li className="nav-item">*/}
                {/*        <Link to={"/admin"} className="nav-link">*/}
                {/*            Admin Board*/}
                {/*        </Link>*/}
                {/*    </li>*/}
                {/*)}*/}

                {/*{showModeratorBoard && (*/}
                {/*    <li className="nav-item">*/}
                {/*        <Link to={"/mod"} className="nav-link">*/}
                {/*            Moderator Board*/}
                {/*        </Link>*/}
                {/*    </li>*/}
                {/*)}*/}

                {/*{currentUser && (*/}
                {/*    <li className="nav-item">*/}
                {/*        <Link to={"/user"} className="nav-link">*/}
                {/*            User*/}
                {/*        </Link>*/}
                {/*    </li>*/}
                {/*)}*/}
            </div>

            {currentUser ? (
                <div className="navbar-nav ml-auto">
                    <li className="nav-item">
                        <Link to={"/profile"} className="nav-link">
                            {currentUser.username}
                        </Link>
                    </li>
                    <li className="nav-item">
                        <a href="/login" className="nav-link" onClick={logOut}>
                            LogOut
                        </a>
                    </li>
                </div>
            ) : (
                <div className="navbar-nav ml-auto">
                    <li className="nav-item">
                        <Link to={"/login"} className="nav-link">
                            Login
                        </Link>
                    </li>

                    <li className="nav-item">
                        <Link to={"/register"} className="nav-link">
                            Sign Up
                        </Link>
                    </li>
                </div>
            )}
        </nav>
    );
};

export default Navbar;