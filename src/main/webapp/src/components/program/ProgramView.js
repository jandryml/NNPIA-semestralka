import {forwardRef, useEffect, useState} from "react";

import ProgramListItem from "./ProgramListItem";
import GenericList from "../reusables/GenericList";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import moment from 'moment'
import {useHistory} from "react-router";

const ProgramView = () => {
    const [startDate, setStartDate] = useState(new Date());
    const [url, setUrl] = useState('http://localhost:8080/api/program?date=' + moment(startDate).format("L"));
    const history = useHistory();

    const ExampleCustomInput = forwardRef(({ value, onClick }, ref) => (
        <button className="example-custom-input" onClick={onClick} ref={ref}>
            {value}
        </button>
    ));

    useEffect(() => {
        setUrl('http://localhost:8080/api/program?date=' + moment(startDate).format("L"))
    }, [startDate]);

    function handleClick() {
        history.push("/program/add");
    }

    return (
        <div>
            {"Select date: "}
            <DatePicker
                selected={startDate}
                dateFormat="dd/MM/yyyy"
                customInput={<ExampleCustomInput />}
                onChange={date => {
                    setStartDate(date);
                }}
            />
            {startDate && <GenericList title="Program for day" ListItem={ProgramListItem}
                                       url={url}/>}
            <button onClick={handleClick}>Add program</button>

        </div>
    );
};

export default ProgramView;
