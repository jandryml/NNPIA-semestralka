import {forwardRef, useEffect, useState} from "react";

import ProgramListItem from "./ProgramListItem";
import GenericList from "../reusables/GenericList";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import moment from 'moment'

const ProgramView = () => {
    const [startDate, setStartDate] = useState(new Date());
    const [url, setUrl] = useState('http://localhost:8080/api/program?date=' + moment(startDate).format("L"));

    const ExampleCustomInput = forwardRef(({ value, onClick }, ref) => (
        <button className="example-custom-input" onClick={onClick} ref={ref}>
            {value}
        </button>
    ));

    useEffect(() => {
        setUrl('http://localhost:8080/api/program?date=' + moment(startDate).format("L"))
    }, [startDate]);

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
        </div>
    );
};

export default ProgramView;
